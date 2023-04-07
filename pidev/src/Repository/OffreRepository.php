<?php

namespace App\Repository;

use App\Entity\Offre;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @method Offre|null find($id, $lockMode = null, $lockVersion = null)
 * @method Offre|null findOneBy(array $criteria, array $orderBy = null)
 * @method Offre[]    findAll()
 * @method Offre[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class OffreRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Offre::class);
    }

    public function create(Offre $offre): void
    {
        $this->_em->persist($offre);
        $this->_em->flush();
    }

    public function read(int $id): ?Offre
    {
        return $this->find($id);
    }

    public function update(Offre $offre): void
    {
        $this->_em->flush();
    }

    public function delete(Offre $offre): void
    {
        $this->_em->remove($offre);
        $this->_em->flush();
    }
    public function getChoices(): array
    {
        $offres = $this->findAll();
        $choices = [];

        foreach ($offres as $offre) {
            $choices[$offre->getDescriptionOf()] = $offre->getIdOffre();
        }

        return $choices;
    }
}