<?php
namespace App\Repository;

use App\Entity\Maintenance;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Maintenance|null find($id, $lockMode = null, $lockVersion = null)
 * @method Maintenance|null findOneBy(array $criteria, array $orderBy = null)
 * @method Maintenance[]    findAll()
 * @method Maintenance[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class MaintenanceRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Maintenance::class);
    }

    public function create(Maintenance $maintenance): void
    {
        $this->_em->persist($maintenance);
        $this->_em->flush();
    }

    public function read(int $id): ?Maintenance
    {
        return $this->find($id);
    }

    public function update(Maintenance $maintenance): void
    {
        $this->_em->flush();
    }

    public function delete(Maintenance $maintenance): void
    {
        $this->_em->remove($maintenance);
        $this->_em->flush();
    }

    public function getAverageRating(): ?float
    {
        $qb = $this->createQueryBuilder('m');
        $qb->select('AVG(m.rating)');
        return $qb->getQuery()->getSingleScalarResult();
    }
}
